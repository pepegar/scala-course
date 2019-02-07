package course

import cats.effect._
import fs2.StreamApp.ExitCode
import fs2.{Stream, StreamApp}
import org.http4s._
import org.http4s.dsl.io._
import org.http4s.server.blaze._
import org.http4s.server.staticcontent.WebjarService.{WebjarAsset, Config}
import org.http4s.server.staticcontent.webjarService
import scala.concurrent.ExecutionContext.Implicits.global

object Main extends StreamApp[IO] {
  def static(file: String, request: Request[IO]) =
    StaticFile.fromResource("/" + file, Some(request)).getOrElseF(NotFound())

  val service = HttpService[IO] {
    case request @ GET -> Root / path if List(".js", ".css", ".map", ".html", ".webm").exists(path.endsWith) =>
      static(path, request)
  }


  def isJsAsset(asset: WebjarAsset): Boolean =
    asset.asset.endsWith(".js")

  val webjars: HttpService[IO] = webjarService(
    Config(
      filter = isJsAsset
    )
  )

  override def stream(args: List[String], requestShutdown: IO[Unit]): Stream[IO, ExitCode] =
    BlazeBuilder[IO]
      .bindHttp(8080, "localhost")
      .mountService(service, "/")
      .mountService(webjars, "/")
      .serve
}

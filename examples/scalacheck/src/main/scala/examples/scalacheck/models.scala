package examples.scalacheck


// from should be an email address
// to should be an email address
// subject should be less than 150 chars long
// content should be less than 30000 chars long
case class Email(from: String, to: String, subject: String, content: String)


object Email {

  // define a smart contstructor that knows how construct a valid email.
  //
  // What should be its return type?
  def fromParts(from: String, to: String, subject: String, content: String) /* : ??? */ = {

  }

}

package examples.scalacheck

import org.scalacheck.Arbitrary
import org.scalacheck.Arbitrary.arbitrary
import org.scalacheck.Gen
import org.scalacheck.Prop._
import org.scalacheck.Properties

class ValidationTest extends Properties("email/validation") {

  property("this is a property") = forAll { (i: Int) =>
    i * i == 3
  }

  // property("this should work") = forAll { (e: Email) =>
  //   e.subject == 3
  // }

}

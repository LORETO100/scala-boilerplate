/*
 * Copyright 2015 Marconi Lanna
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
name := "PROJECT"

version := "0.1"

scalaVersion := "2.11.6"

scalaSource in Compile := baseDirectory.value / "src"

javaSource in Compile := baseDirectory.value / "src"

scalaSource in Test := baseDirectory.value / "test"

javaSource in Test := baseDirectory.value / "test"

resourceDirectory in Test := (scalaSource in Test).value / "resources"

scalacOptions ++= Seq(
  // Emit warning and location for usages of deprecated APIs
    "-deprecation"
  // Specify character encoding used by source files
  , "-encoding", "UTF-8"
  // Emit warning and location for usages of features that should be imported explicitly
  , "-feature"
  // Enable or disable language features (see list below)
  //, "-language:_"
  // Generates faster bytecode by applying optimisations to the program
  //, "-optimise"
  // Target platform for object files
  , "-target:jvm-1.8"
  // Enable additional warnings where generated code depends on assumptions
  , "-unchecked"
  // Indicates user is a developer - issue warnings about anything which seems amiss
  //, "-Xdev"                         // Doesn't play well with ScalaTest
  // Fail the compilation if there are any warnings
  , "-Xfatal-warnings"
  // Turn on future language features
  , "-Xfuture"
  // Enable or disable specific warnings (see list below)
  , "-Xlint:_"
  // Do not adapt an argument list to match the receiver
  , "-Yno-adapted-args"
  // Compile without importing scala.*, java.lang.*, or Predef
  //, "-Yno-imports"
  // Compile without importing Predef
  //, "-Yno-predef"
  // Warn when dead code is identified
  , "-Ywarn-dead-code"
  // Warn when numerics are widened
  //, "-Ywarn-numeric-widen"          // Not really useful
  // Warn when local and private vals, vars, defs, and types are are unused
  , "-Ywarn-unused"
  // Warn when imports are unused
  , "-Ywarn-unused-import"
  // Warn when non-Unit expression results are unused
  , "-Ywarn-value-discard"
)

/*
scalac -language:help

dynamics             Allow direct or indirect subclasses of scala.Dynamic
existentials         Existential types (besides wildcard types) can be written and inferred
experimental.macros  Allow macro defintion (besides implementation and application)
higherKinds          Allow higher-kinded types
implicitConversions  Allow definition of implicit functions called views
postfixOps           Allow postfix operator notation, such as `1 to 10 toList'
reflectiveCalls      Allow reflective access to members of structural types
*/

/*
scalac -Xlint:help

adapted-args               Warn if an argument list is modified to match the receiver
by-name-right-associative  By-name parameter of right associative operator
delayedinit-select         Selecting member of DelayedInit
doc-detached               A ScalaDoc comment appears to be detached from its element
inaccessible               Warn about inaccessible types in method signatures
infer-any                  Warn when a type argument is inferred to be `Any`
missing-interpolator       A string literal appears to be missing an interpolator id
nullary-override           Warn when non-nullary `def f()' overrides nullary `def f'
nullary-unit               Warn when nullary methods return Unit
option-implicit            Option.apply used implicit view
package-object-classes     Class or object defined in package object
poly-implicit-overload     Parameterized overloaded implicit methods are not visible as view bounds
private-shadow             A private field (or class parameter) shadows a superclass field
type-parameter-shadow      A local type parameter shadows a type already in scope
unsound-match              Pattern match may not be typesafe
*/

// Commonly used libraries
libraryDependencies ++= Seq(
    "commons-codec"                     % "commons-codec"                    % "1.10"
  , "commons-io"                        % "commons-io"                       % "2.4"
  , "commons-validator"                 % "commons-validator"                % "1.4.1"
  , "joda-time"                         % "joda-time"                        % "2.7"
  , "mysql"                             % "mysql-connector-java"             % "5.1.35"
  , "ch.qos.logback"                    % "logback-classic"                  % "1.1.3"
  , "com.github.t3hnar"                %% "scala-bcrypt"                     % "2.4"
  , "com.google.guava"                  % "guava"                            % "18.0"
  , "com.ibm.icu"                       % "icu4j"                            % "55.1"
  , "com.typesafe"                      % "config"                           % "1.3.0"
  , "com.typesafe.scala-logging"       %% "scala-logging"                    % "3.1.0"
  , "com.typesafe.slick"               %% "slick"                            % "3.0.0"
  , "com.univocity"                     % "univocity-parsers"                % "1.5.5"
  , "org.apache.commons"                % "commons-compress"                 % "1.9"
  , "org.apache.commons"                % "commons-lang3"                    % "3.4"
  , "org.apache.commons"                % "commons-math3"                    % "3.5"
  , "org.apache.httpcomponents"         % "httpclient"                       % "4.4.1"
  , "org.joda"                          % "joda-money"                       % "0.10.0"
  , "org.jsoup"                         % "jsoup"                            % "1.8.2"
  , "org.mockito"                       % "mockito-core"                     % "1.10.19"      % Test
  , "org.scalamock"                    %% "scalamock-scalatest-support"      % "3.2.2"        % Test
  , "org.scalatest"                    %% "scalatest"                        % "2.2.5"        % Test
  , "org.seleniumhq.selenium"           % "selenium-java"                    % "2.45.0"       % Test
)

// Improved incremental compilation
incOptions := incOptions.value.withNameHashing(true)

// Improved dependency management
updateOptions := updateOptions.value.withCachedResolution(true)

// Download and create Eclipse source attachments for library dependencies
// EclipseKeys.withSource := true

// Uncomment to enable offline mode
// offline := true

showSuccess := true

showTiming := true

shellPrompt := { state =>
  import scala.Console.{CYAN, RESET}
  val p = Project.extract(state)
  val name = p.getOpt(sbt.Keys.name) getOrElse p.currentProject.id
  s"[$CYAN$name$RESET] $$ "
}

# c3lj

A Clojure library designed to ... well, that part is up to you.

## Setup

1. Install maven
  - `brew install maven`
  - maven is needed to host a local repository
1. Build CCNx
  - downoad source & extract
  - `./configure`
  - `make`
  - `make shared`
  - the jars are here: `la ./lib`
1. Setup Local Jars
  - ..
  - need to read up

## Lein & Maven:

- [Installing jars locally for Leiningen 2](http://www.elangocheran.com/blog/2013/03/installing-jar-files-locally-for-leiningen-2/)
- [Automate by using lein-localrepo plugin](http://www.elangocheran.com/blog/2013/03/installing-jar-files-locally-for-leiningen-2/)
- [Manually add to local maven repo](http://www.pgrs.net/2011/10/30/using-local-jars-with-leiningen/)

## Java Interop Examples

#### Links

Java Interop Example:
- [interop docs](http://clojure.org/java_interop)
- [java_interop & protocols](http://www.jayway.com/2013/02/05/learn-clojure-using-records-and-protocols/)
- [caves of clojure - protocols](http://stevelosh.com/blog/2012/07/caves-of-clojure-interlude-1/)
- [eclipse interop gist](https://gist.github.com/laurentpetit/1951764)
- [jdbc examples](http://en.wikibooks.org/wiki/Clojure_Programming/Examples/JDBC_Examples)

Other Links:
- [clojure cheat sheet](http://clojure.org/cheatsheet)

Example:

```clojure

(ns clojure-tutorial.java_interop)

(import
 '(java.util Calendar GregorianCalendar)
 '(javax.swing JFrame JLabel))

;two ways to access constants in java class

(. java.util.Calendar APRIL) ; -> 3
(. Calendar APRIL)
(println (. Calendar APRIL))

; two ways to invoke a static method in a java class
(println (. Math pow 2 4)) ; -> 16.0
(println (Math/pow 2 4))

; two ways to invoke a constructor for a java class

(def calendar (new GregorianCalendar 2008 Calendar/APRIL 16)) ; April 16, 2008
(def calendar (GregorianCalendar. 2008 Calendar/APRIL 16))
(println (. calendar toString))

;two ways to invoke an instance method in a java object

(. calendar add Calendar/MONTH 2)
(println (. calendar get Calendar/MONTH)) ; -> 5

(.add calendar Calendar/MONTH 2) ; preferred method
(println (.get calendar Calendar/MONTH)) ; -> 7

; method calls can be chained using the .. macro

(def a (. (. calendar getTimeZone) getDisplayName)) ; long way
(println a)

(def b (.. calendar getTimeZone getDisplayName)) ; -> 'Central Standard Time'
(println b)

; .?. can be used to catch and return nil if and methods in the chain return a null. This avoids getting a "NullPointerException"

;doto function is used to invoke many methods on the same object

(doto calendar
      (.set Calendar/YEAR 1981)
      (.set Calendar/MONTH Calendar/AUGUST)
      (.set Calendar/DATE 1))
(def formatter (java.text.DateFormat/getDateInstance))
(def x (.format formatter (.getTime calendar))) ; -> "Aug 1, 1981"
(println x)

;memfn macro for calling java methods instead of using anonymous functions

(println (map #(.substring %1 %2)
               ["Moe" "Larry" "Curly"] [1 2 3])) ; -> (oe rry ly)

(println (map (memfn substring beginIndex)
               ["Moe" "Larry" "Curly"] [1 2 3])) ;

```

## CCNx Java Classes:

#### org.ccnx.ccn

[CCNBase](http://www.ccnx.org/releases/latest/doc/javacode/html/interfaceorg_1_1ccnx_1_1ccn_1_1_c_c_n_base.html)
- [CCNHandle](http://www.ccnx.org/releases/latest/doc/javacode/html/classorg_1_1ccnx_1_1ccn_1_1_c_c_n_handle.html)

#### org.ccnx.impl

[encoding.GenericXMLHandler](http://www.ccnx.org/releases/latest/doc/javacode/html/classorg_1_1ccnx_1_1ccn_1_1impl_1_1encoding_1_1_generic_x_m_l_handler.html)
- [encoding.GenericXMLEncoder](http://www.ccnx.org/releases/latest/doc/javacode/html/classorg_1_1ccnx_1_1ccn_1_1impl_1_1encoding_1_1_generic_x_m_l_encoder.html)
- [encoding.GenericXMLDecoder](http://www.ccnx.org/releases/latest/doc/javacode/html/classorg_1_1ccnx_1_1ccn_1_1impl_1_1encoding_1_1_generic_x_m_l_decoder.html)

## Usage

FIXME

## License

Copyright © 2013 FIXME

Distributed under the Eclipse Public License, the same as Clojure.

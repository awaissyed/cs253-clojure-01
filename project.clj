(defproject cs253-clojure-01 "0.1.0-SNAPSHOT"

  :description "FIXME: write description"
  :url "http://example.com/FIXME"

  :dependencies [[org.clojure/clojure "1.7.0"]
                 [selmer "0.8.4"]
                 [com.taoensso/timbre "4.0.2"]
                 [com.taoensso/tower "3.0.2"]
                 [markdown-clj "0.9.67"]
                 [environ "1.0.0"]
                 [compojure "1.4.0"]
                 [ring/ring-defaults "0.1.5"]
                 [ring/ring-session-timeout "0.1.0"]
                 [ring "1.4.0"
                  :exclusions [ring/ring-jetty-adapter]]
                 [metosin/ring-middleware-format "0.6.0"]
                 [metosin/ring-http-response "0.6.3"]
                 [bouncer "0.3.3"]
                 [prone "0.8.2"]
                 [org.clojure/tools.nrepl "0.2.10"]
                 [http-kit "2.1.19"]]

  :min-lein-version "2.0.0"
  :uberjar-name "cs253-clojure-01.jar"
  :jvm-opts ["-server"]

  :main cs253-clojure-01.core

  :plugins [[lein-environ "1.0.0"]
            [lein-ancient "0.6.5"]
            [lein-ring "0.9.6"]]
  :ring
  {:handler cs253-clojure-01.handler/app
   :init cs253-clojure-01.handler/init
   :destroy cs253-clojure-01.handler/destroy
   :uberwar-name "cs253-clojure-01.war"}
  
  :profiles
  {:uberjar {:omit-source true
             :env {:production true}
             :aot :all}
   :dev {:dependencies [[ring-mock "0.1.5"]
                        [ring/ring-devel "1.4.0"]
                        [pjstadig/humane-test-output "0.7.0"]]
         
         
         ;;when set the application start the nREPL server on load

         :repl-options {:init-ns cs253-clojure-01.core}
         :injections [(require 'pjstadig.humane-test-output)
                      (pjstadig.humane-test-output/activate!)]
         :env {:dev        true
               :nrepl-port 7001}}})

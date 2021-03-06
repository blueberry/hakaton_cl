(ns prijava.controller.controller
  (:require
    [clostache.parser :as clostache]
    [prijava.model.timovi :as timovi-model]
    ))

(defn read-template [template-name]
  (slurp (clojure.java.io/resource
           (str "views/" template-name ".mustache"))))

(defn render-template [template-file params]
  (clostache/render (read-template template-file) params))


(defn index []
  (render-template "index" {}))

(defn login []
  (render-template "login" {}))

(defn izmenitiTim [id]
  (render-template "izmenaTim" {:timovi (timovi-model/get id)
                                     :gradovi (timovi-model/sviGradovi)
                                        :clanovi (timovi-model/sviClanoviTima id)
                                     }))

(defn clanoviTima [id]
  (render-template "clanovi" {:clanovi (timovi-model/sviClanoviTima id)
                              }))

(defn dodatiTim []
  (render-template "noviTim" {:gradovi (timovi-model/sviGradovi)
                                     }))
(defn dodatiClana [id]
  (render-template "noviClanTima" {:idtim id}
                   ))

(defn timovi []
  (render-template "timovi" {:timovi (timovi-model/sviTimoviJoinGradovi)
                                :gradovi (timovi-model/sviGradovi)
                                }))
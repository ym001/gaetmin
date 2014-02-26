 (defun graine() (rem (get-internal-real-time)2)); graine aléatoire
 
 ;entrée un tableau de valeur binaire
 ;retourne un réel représentant l espérance mathématique du tableau
 (defun esperance(tab) ;
	(setq compteur 0)
	(loop for i from 0 to nbf do
		(if (= 1 (svref tab i)) (incf compteur) )
	)
	(/ compteur nb)
 )
 
 ;entrée un tableau de valeur binaire
 ;retourne un réel représentant la variance mathématique du tableau
 (defun variance(tab) ()
 (setq espe (esperance tableau))
 (setq vari 0)
 (loop for i from 0 to nbf do
		(setq vari(+ vari (* (- (svref tab i) espe)(- (svref tab i) espe)))
		)
 )
 	(/ vari nb)
 )
 
 (PRINT "Début du programme")
 (setq nb 1000)
 (setq tableau(make-array nb :initial-element 0)) ;; Creates an array 
 (print(format NIL "Génération de ~A bits aléatoires" nb))

 (setq t1 (get-internal-real-time))
 (setq nbf (- nb 1))
 (loop for i from 0 to nbf do
	(setf (aref tableau i) (graine)
	)
 )
 (setq t2 (get-internal-real-time))
 
 (print(format NIL "Tableau ~A " tableau))
 (print(format NIL "Temps de génération ~A ms" (float(* 1000 (/ (- t2 t1) internal-time-units-per-second)))))
 (print(format NIL "Espérance : ~A " (float (esperance tableau))))
 (print(format NIL "Variance : ~A " (float (variance tableau))))
 (PRINT "Fin du programme")



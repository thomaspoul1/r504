#!/usr/bin/python3
def puissance(a, b):
	if not type(a) is int:
		raise Exception("entier")
	if not type(b) is int:
		raise Exception("entier")
	
	if b < 0:
        	return 1 / (a ** abs(b))

	else:
		resultat = 1
	for _ in range(b):
		resultat *= a
		
	return resultat


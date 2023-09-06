def puissance(a, b):
    #if not (isinstance(a, int) and isinstance(b, int)):
	if type(a) is int:
		print("entier")
	if type(b) is int:
		print("entier")
	else:	
		print("pas entier")
	return a**b

def puissance(a, b):
    #if not (isinstance(a, int) and isinstance(b, int)):
	if not type(a) is int:
		raise Exception("entier")
	if not type(b) is int:
		raise Exception("entier")
	else:	
		print("pas entier")
	return a**b



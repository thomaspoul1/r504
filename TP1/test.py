#!/usr/bin/python3
import pytest
import fonctions

def test_1 ( ) :
	assert fonctions.puissance ( 2 , 3 ) == 8
	assert fonctions.puissance ( 2 , 2 ) == 4
	
def test_2 ( ) :
	assert fonctions.puissance ( -2 , 3 ) == -8
	assert fonctions.puissance ( -2 , 2 ) == 4
	
def test_3 ( ) :
	assert fonctions.puissance ( 0 , 0 ) == 1
	assert fonctions.puissance ( 1 ,-2 ) == 1	
	assert fonctions.puissance ( 1 , 2 ) == 1
	assert fonctions.puissance ( 2 ,-2 ) == 1/4
	assert fonctions.puissance ( 0 , 2 ) == 0

#!/bin/bash
# Exécute debsecan et enregistre les résultats dans un fichier log
sudo debsecan > ~/Desktop/tp-r504/TP13/fichier_log

# Assurez-vous que le fichier log est accessible en écriture
chmod 644 ~/Desktop/tp-r504/TP13/fichier_log

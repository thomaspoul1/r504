#!/bin/bash

# Script pour exécuter la recherche de vulnérabilités tous les jours à 02h30

# Chemin du fichier de journal pour enregistrer les résultats de l'analyse
LOG_FILE="/var/log/vulnerability_scan.log"

# Exécuter debsecan pour rechercher les vulnérabilités
echo "[$(date)] Début de l'analyse des vulnérabilités" >> "$LOG_FILE"
debsecan --suite=all --format=multiline >> "$LOG_FILE"
echo "[$(date)] Fin de l'analyse des vulnérabilités" >> "$LOG_FILE"

# Seuil de vulnérabilités
SEUIL=5

# Nombre de vulnérabilités trouvées
NB_VULNERABILITES=$(debsecan --suite=all --format=multiline | grep "Vulnerability check" | awk '{print $4}')

if [ "$NB_VULNERABILITES" -gt "$SEUIL" ]; then
    # Envoyer un e-mail d'alerte
    echo "ALERTE : Nombre de vulnérabilités dépassant le seuil autorisé." | mail -s "Alerte Vulnérabilités" mail@mail.com
fi



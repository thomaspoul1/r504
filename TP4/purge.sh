#!/bin/bash
docker rm -f $(docker ps -aq)

# Supprimer les réseaux non utilisés
docker network prune -f

# Supprimer les volumes non utilisés
docker volume prune -f

#!/bin/bash

#Atualiza o apt-get

echo "Atualizando servidor"

sudo apt-get update

sudo apt-get update -y

#instala o apache e o unzip

echo "Instalando o apache e o unzip"

sudo apt-get install apache2 -y

sudo apt-get install unzip -y

#baixa um site/sistema

echo "Baixando o conteúdo"

wget -P /tmp https://github.com/denilsonbonatti/linux-site-dio/archive/refs/heads/main.zip

#descompacta e copia para a pasta padrão do Apache

echo "Colocando na pasta padrão"

cd /tmp

unzip main.zip

cd linux-site-dio-main

cp -R ./ /var/www/html/

echo "Instalação concluída"

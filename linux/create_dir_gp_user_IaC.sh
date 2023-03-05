#!/bin/bash

echo "Iniciando script de IaC do curso AWS da DIO.me"

echo "Criando diretórios"

sudo mkdir	/publico /adm /ven /sec

ls -l /

echo "Criando grupos"

sudo groupadd GRP_ADM 
sudo groupadd GRP_VEN
sudo groupadd GRP_SEC

echo "Dando as permissões aos grupos nos respectivos diretórios"

sudo chmod 777 /publico
sudo chmod 770 /adm /ven /sec
sudo chown root:GRP_ADM /adm
sudo chown root:GRP_VEN /ven
sudo chown root:GRP_SEC /sec

echo "Criando usuários e já adicionando ao grupos"

# -c => descrição 
# -m => cria diretorio no /home 
# -s => da acesso ao bash 
# -G => especifica os grupos
# -p => cria a senha usando uma chamada ao openssl pra criptografar
# Antes era assim que passava a senha: -p $(openssl passwd -crypt Senha12345)
# mas o -crypt foi removido e então pode-se passar o -1 no lugar e então será usado o MD5
sudo useradd carlos -c "Carlos Pereira" -m -s /bin/bash -G GRP_ADM -p $(openssl passwd -1 Senha12345)
sudo useradd maria -c "Maria da Silva" -m -s /bin/bash -G GRP_ADM -p $(openssl passwd -1 Senha12345)
sudo useradd joao_ -c "João O" -m -s /bin/bash -G GRP_ADM -p $(openssl passwd -1 Senha12345)
sudo useradd debora -c "Debora Y." -m -s /bin/bash -G GRP_VEN -p $(openssl passwd -1 Senha12345)
sudo useradd sebastiana -c "Sebastiana Maia" -m -s /bin/bash -G GRP_VEN -p $(openssl passwd -1 Senha12345)
sudo useradd roberto -c "Alberto Roberto" -m -s /bin/bash -G GRP_VEN -p $(openssl passwd -1 Senha12345)
sudo useradd josefina -c "Josefina Perna Fina"  -m -s /bin/bash -G GRP_SEC -p $(openssl passwd -1 Senha12345)
sudo useradd amanda -c "Amanda Silva" -m -s /bin/bash -G GRP_SEC -p $(openssl passwd -1 Senha12345)
sudo useradd rogerio -c "Rogerio A." -m -s /bin/bash -G GRP_SEC -p $(openssl passwd -1 Senha12345)


echo "Terminando script"



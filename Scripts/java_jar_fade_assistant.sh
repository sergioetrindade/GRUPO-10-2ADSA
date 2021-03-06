#!/bin/bash

#resources
fade='teste-api-1.0-SNAPSHOT-jar-with-dependencies.jar'
baixar='https://github.com/sergioetrindade/downloadjar/raw/master/teste-api-1.0-SNAPSHOT-jar-with-dependencies.jar'
script_bd='https://github.com/sergioetrindade/downloadjar/raw/master/scriptBd.sql'


executando_sistema_fade() { #Inicia a API

echo "$(tput setaf 10)[System Fade]: Sistema pronto para ser iniciado, deseja inicia-lo? s/n"
read confirm

if [ \"$confirm\" == \"s\" ]; then
echo "$(tput setaf 10)[System Fade]: Iniciando o seu Sistema, por favor aguarde ..."

java -jar $fade 1> /dev/null 2> /dev/stdout

else
    echo ""
    echo "$(tput setaf 10)[System Fade]: Inicialização do Sistema  cancelada "
    sleep 1
    echo ""

    echo "$(tput setaf 10)[System Fade]: Para instalar novamente inicie o programa"
    sleep 1
    echo ""

    echo "$(tput setaf 10)[System Fade]: Encerrando instalação..."

    exit 0

    fi

}


instalando_sistema_fade() { #Instala o software
    
if [ "$( ls -l |  grep $fade | wc -l)" -eq "0" ]; then

    echo "$(tput setaf 10)[System Fade]: Baixando o Sistema Fade ..."


        wget $baixar 1> /dev/null 2> /dev/stdout

        executando_sistema_fade


else

    sleep 2
        
    executando_sistema_fade
  

    if [ $? -eq 1 ]; then 

    echo "$(tput setaf 10)[System Fade]: Erro na instalação do Programa. "

    sleep 1 

    exit 0 

    fi


fi    

}


criar_container() { #cria o conteiner docker

	if [ "$(sudo docker ps -aqf 'name=ConteinerFade' | wc -l)" -eq "0" ]; then
		echo ""
		echo -e "$(tput setaf 10)[System Fade]:$(tput setaf 7)Finalizando instalação do docker..."
		sudo docker run -d -p 3306:3306 --name ConteinerBD -e "MYSQL_ROOT_PASSWORD=urubu100" imagem_fade:1.0  1> /dev/null 2> /dev/stdout		
	
	fi

	instalando_sistema_fade	

}

gerar_imagem_personalizada() { #cria uma imagem mysql docker modificada com o banco inserido

	if [ "$( ls -l | grep 'scriptBd.sql' | wc -l )" -eq "0" ]; then
		wget $script_bd 1> /dev/null 2> /dev/stdout

	fi

	if [ "$( ls -l | grep 'dockerfile' | wc -l )" -eq "0" ]; then
echo "
FROM mysql:5.7

ENV MYSQL_DATABASE fadesolutions

COPY scriptBd.sql /docker-entrypoint-initdb.d/
" > dockerfile 

	fi

	if [ "$(sudo docker images | grep 'imagem_fade' | wc -l)" -eq "0" ]; then
		sudo docker build -t imagem_fade:1.0 . 1> /dev/null 2> /dev/stdout

	fi

	criar_container

}

instalar_sql_docker() { #baixa a imagem do sql do docker

	if [ "$(sudo docker images | grep 'mysql' | wc -l)" -eq "0" ]; then
	echo ""
	echo -e "$(tput setaf 10)[System Fade]:$(tput setaf 7)Criando imagem docker..."
		sudo docker pull mysql:5.7 1> /dev/null 2> /dev/stdout
		gerar_imagem_personalizada

	else
		gerar_imagem_personalizada

	fi

}


ligar_docker(){ #liga o docker 

if [ "$(sudo service docker status | head -2 | tail -1 | awk '{print $4}' | sed 's/\;//g')" != "enabled" ]; 
    then 
		sudo systemctl enable docker

	fi

	if [ "$(sudo systemctl is-active docker)" != "active" ]; then
		sudo systemctl start docker

    fi
		
		instalar_sql_docker


}

instalar_docker() { #Instala o docker

	if [ "$(dpkg --get-selections | grep 'docker.io' | wc -l)" -eq "0" ]; then
		echo ""
		echo -e "$(tput setaf 10)[System Fade]:$(tput setaf 7)Instalando docker..."
		sudo apt update -y  1> /dev/null 2> /dev/stdout 
		sudo apt install docker.io -y 1> /dev/null 2> /dev/stdout
		ligar_docker

	else
		ligar_docker
	
	fi
}

verifica_java() { #Validando se o java está instalado !!

echo  "$(tput setaf 10)[System Fade]:$(tput setaf 7) Olá Cliente Fade, estamos analisando os requisitos para instalar o sistema, por favor aguarde ...!!!;"
echo  "$(tput setaf 10)[System Fade]:$(tput setaf 7) Vamos verificar se você ja possui o Java instalado, por favor aguarde enquanto verificamos ...;"

sleep 3


if [ "$(dpkg --get-selections | grep 'default-jre' | wc -l)" -eq "0" ];
	then
		echo "$(tput setaf 10)[System Fade]:$(tput setaf 7) : Você não tem a versão do java instalada no seu computador, aguarde enquanto instalamos ... "
	
					echo "$(tput setaf 10)[System Fade]:$(tput setaf 7) Preparando para instalar a versão 11 do Java, por favor aguarde enquanto instalamos ..."
					sudo apt install default-jre ; apt install openjdk-11-jre-headless; -y
					clear
					echo "$(tput setaf 10)[System Fade]:$(tput setaf 7) Java instalado com sucesso! "
                    echo "$(tput setaf 10)[System Fade]:$(tput setaf 7) Aguarde para iniciar a instalação do seu sistema Fade ... "
                    instalando_sistema_fade
else
		echo "$(tput setaf 10)[System Fade]:$(tput setaf 7) : Você ja tem o Java instalado por favor aguardo enquanto verificamos a versão"
                    
                    instalar_docker 
fi

}

verifica_java


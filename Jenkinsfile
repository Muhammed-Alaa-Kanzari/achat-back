pipeline {
    agent any

    tools {
        maven 'M2_HOME'
        jdk 'JAVA_HOME'
    }
    
    stages {
        stage('Getting project from Github') {
            steps {
                git branch : 'Facture' ,
                    url : 'https://github.com/Muhammed-Alaa-Kanzari/achat-back';
            }
        }
        stage('Cleaning the project') {
            steps{
                sh 'mvn clean'
            }

        }
        stage ('Integration testing'){	
		  	steps{
		  		  sh 'mvn verify -DskipUnitTests'
		  	 }
		  }
        
stage ('Build our image'){
            steps{
                sh 'sudo docker build --build-arg IP=0.0.0.0 -t nourcheinecheikh/achat_back .'
            }
        }
        stage ('Deploy our image'){
            steps{
                sh 'sudo docker login -u nourcheinecheikh -p 123nourcheine';
                sh 'sudo docker push nourcheinecheikh/achat_back'
                }
            }

    stage ('artifact construction') {
            steps{
                sh 'mvn  package'
            }
        }

    }

    
}
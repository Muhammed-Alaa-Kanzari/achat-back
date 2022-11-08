pipeline {
    agent any

    tools {
        maven 'M2_HOME'
        jdk 'JAVA_HOME'
    }
     stages {
        stage('Git Checkout') {
            steps {
                git branch : 'operateur' ,
                    url : 'https://github.com/Muhammed-Alaa-Kanzari/achat-back';
            }
        }
        
         stage('Cleaning the project') {
            steps{
                sh 'mvn clean'
            }
        }
        
        stage (	'Unit testing ' ) {
			   steps{
				 sh 'mvn test'  		 
				}
			}	
			
			
        
        stage ('Integration testing'){	
		  	steps{
		  		  sh 'mvn verify -DskipUnitTests'
		  	 }
		  }
        stage ('Maven Build'){	
		  	steps{
		  		  sh 'mvn clean install '
		  	 }
		 }
		 
		  stage ('Artifact construction') {
            steps{
                sh 'mvn  package'
            }
        }
		 
		 stage ('SonarQube analysis'){	
		  	steps{
		  		script{
		  				withSonarQubeEnv(credentialsId: 'sonarToken', installationName: 'sonarServer') {		  			
		  		       	sh 'mvn clean package sonar:sonar '
		            		}
		              }		
		  	      }	
		   }	
		   
		   
		   
		   
		   	
    }
         
}




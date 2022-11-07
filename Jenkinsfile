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
        

    }
}
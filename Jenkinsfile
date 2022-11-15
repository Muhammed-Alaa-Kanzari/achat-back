pipeline {
    agent any
    
  
    
    
    stages {
        stage('Git 5SE2') {
            steps {
               git branch :'Gestion_Produits',
                url : 'https://github.com/Muhammed-Alaa-Kanzari/achat-back.git'
            }
        
    }
      

     stage('mvn compile') {
            steps {
              
               sh 'mvn compile'
            }}
        
    stage('mvn package') {
            steps {
              
               sh 'mvn package'
            }}
            
            
     stage('mvn test') {
            steps {
              
               sh 'mvn test'
            }
    }        
            
     
            
    stage('SonarQube analysis') {
                  steps{
                      script{
                  
    def scannerHome = tool 'sonar';
     withSonarQubeEnv('sonar') {
      sh "${scannerHome}/bin/sonar-scanner \
      -D sonar.login=admin \
      -D sonar.password=sonar \
      -D sonar.projectKey=devopsproject \
      -Dsonar.java.binaries=target/classes \
      -Dsonar.junit.reportPaths=target/test-classes/ \
      -D sonar.host.url=http:192.168.184.149:9000/"
    }}}
  }
            
           
                    
    stage('deploy nexus'){
                
                steps{
         sh "mvn deploy"
                }}
                        
    
            
    
    stage('build images') {
            steps {
              
               sh 'docker build -t bellaherich/devops .'
            }
        
    
    }
    
    
    stage ('Deploy our image'){
            steps{
                sh 'sudo docker login -u bellaherich -p waelesprit1997';
                sh 'sudo docker push bellaherich/devops'
                }
            }
    
    
    
    stage ('Docker compose'){
            steps{
           
                sh 'docker-compose up -d'
                }
            }


    }}
    
    
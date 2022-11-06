properties([pipelineTriggers([githubPush()])])
pipeline {
    agent any 
        tools { 
        maven "MyMaven"
        
    }
       

    stages {
          stage('Tools up') {
            steps {
                warnError('all up'){
                     sh ' docker-compose -f docker-compose-tools.yml up -d'}
                }

        }
        
        stage('git clone') {
            steps {
               git branch: 'main', url: 'https://github.com/iheeb9/devops_pipline'
        
            }
        }
        stage('clean package') {
            steps {
             sh 'mvn clean install -DskipTests=true'
        
        
            }
        }
        stage('mvn test') {
            steps {
             sh 'mvn test'
        
        
            }
        }
   
        
    
        
        
        
    }
    
    
        
        
}



properties([pipelineTriggers([githubPush()])])
pipeline {
    agent any 
        tools { 
        maven "MyProjectDevops"
        
    }
  
      

    stages {

        
        stage('git clone') {
            steps {
               git branch: 'chames-devops', url: 'https://github.com/iheeb9/devops_pipline'
        
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
    
    
      post{
        always{
        
        emailext body: 'jenkins', subject: 'jenkins', to: 'iheb.youssef@esprit.tn'
        }
        
    }    
        
}

properties([pipelineTriggers([githubPush()])])
pipeline {
    agent any 
        tools { 
        maven "MyMaven"
        
    }
       

    stages {
        stage('git clone') {
            steps {
               git branch: 'main', url: 'https://github.com/iheeb9/devops_pipline'
        
            }
        }
        stage('clean package') {
            steps {
             sh 'mvn clean install'
        
        
            }
        }
         stage('sonarqube') {
            steps {
            withSonarQubeEnv( 'sonarqube:8.9.7-community') {
                 sh 'mvn sonar:sonar'
   
                }
        
        
            }
        }
                stage('Nexus') {
            steps {
                script{
                   nexusPublisher nexusInstanceId: 'nexus3', nexusRepositoryId: 'Maven-', packages: []              
                }
            }
        }
        
        stage('docker') {
            steps {
             sh 'ansible --version'
        
        
            }
        }
        
        
        
    }
    
    post{
        always{
        
        emailext body: 'jenkins', subject: 'jenkins', to: 'iheb.youssef@esprit.tn'
        }
        
    }
        
        
}

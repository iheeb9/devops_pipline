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
                    nexusArtifactUploader artifacts: [[artifactId: 'tpAchatProject', classifier: '', file: 'target/tpAchatProject-1.0', type: 'jar']], credentialsId: 'nexus-cred', groupId: 'org.springframework.boot', nexusUrl: '192.168.88.135:8081', nexusVersion: 'nexus3', protocol: 'http', repository: 'Maven-', version: '2.5.3'
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

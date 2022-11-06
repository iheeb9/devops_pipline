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
             sh 'mvn clean install -DskipTests=true'
        
        
            }
        }
     
         stage('buildimage') {
            steps {
                 sh 'ansible-playbook ansible.playbook.yml '
   
            }
        }
        
         stage('push docker hub') {
            steps {
                 sh 'docker push iheeb9/test'
   
            }
        }
        
        
    
        
        
        
    }
    
    
        
        
}

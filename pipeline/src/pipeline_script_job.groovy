import hudson.model.*;

println env.JOB_NAME
println env.BUILD_NUMBER
println env.WORKSPACE

pipeline{

    agent any
    stages{
        stage("init") {
            steps{
                script{
                    println "欢迎来到Anthony的Pipeline教程。"
                    model_test = load env.WORKSPACE + "/pipeline/module/pipeline_demo_module.groovy"
                }
            }
        }
        stage("Test Method") {
            steps{
                script{
                    log_files = model_test.find_files('**/*.log')
                    file_path = env.WORKSPACE + "/testdata/test.json"
                    json_file = model_test.read_json_file(file_path)
                    json_string = '{"a":"a","b":"b"}'
                    json_text = model_test.read_json_text(json_string)
                    tofile_path = env.WORKSPACE + "/testdata/new.json"
                    model_test.write_json_file(json_string,tofile_path)
                }
            }
        }
    }
}


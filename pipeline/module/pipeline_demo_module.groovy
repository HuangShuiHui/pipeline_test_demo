import hudson.model.*;
import groovy.json.*;

def find_files(filetype){
    def files = findFiles(glob:filetype)
    for (file in files){
        println file.name
    }
}

def read_json_file(file_path){
    def propMap = readJSON file : file_path
    propMap.each {
        println(it.key+"="+it.value)
    }
}

def read_json_text(json_string){
    def propMap = readJSON text : json_string
    propMap.each{
        println(it.key+"+"+it.value)
    }

}

def write_json_file(json_string, tofile_path){
        def input = readJSON text : json_string
        writeJson file : tofile_path,json : input
}

return this;
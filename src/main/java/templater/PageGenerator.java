package templater;


import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.Map;

public class PageGenerator{
    private static final String HTML_DIR = "templates";
    private static final Configuration CFG = new Configuration();


    public static String getPage(String fileName, Map<String,Object> data){
        Writer stream = new StringWriter();
        try{
            Template template = CFG.getTemplate(HTML_DIR + File.separator + fileName);
            template.process(data,stream);
        }catch (IOException | TemplateException e){
            e.printStackTrace();
        }

        return stream.toString();
    }


}

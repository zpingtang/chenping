package com.bigdata.hive;

import org.apache.hadoop.hive.ql.exec.Description;
import org.apache.hadoop.hive.ql.exec.UDF;
import org.apache.hadoop.io.Text;

/**
 * Created by Administrator on 2017/10/9 0009.
 */
@Description(name = "sayhello",
        value = "_FUNC_(input_str) - returns hellonihao: input_str",
        extended = "Example:\n "
                + "  > SELECT _FUNC_('zhangsan') FROM src LIMIT 1;\n"
                + "  'hellonihao: zhangsan'\n")
public class HelloUdfmine extends UDF{
    public Text evaluate(Text input){
        return new Text("Hellonihao: "+input);
    }

    public static void main(String[] args) {
        HelloUdfmine  udf = new HelloUdfmine();
        System.out.println(udf.evaluate(new Text("zhangsan")));
    }
}

package io.codeforall.fanstatics;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Hello world!
 */


@Controller
@ResponseBody
public class HelloWorld {

    /**
     *
     * @param str
     * @return
     */

    @RequestMapping(method = RequestMethod.GET, value = "api/hello")
    public String HelloWorld(@RequestParam(value = "name", defaultValue = "World") String str) {

        return "Hello " + str;
    }
}



package ssb.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ssb.model.Train;

@Controller
public class FirstController {
    /*  класс, который будет обрабатывать запросы, т.е. контроллер */

  /*  @RequestMapping(value = "/",method = RequestMethod.GET)
    public ModelAndView allTrain(){
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.setViewName("maintrain");
        return modelAndView;
    }
*/
    @RequestMapping(value = "/edit",method = RequestMethod.GET)
    public ModelAndView editPage() {
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.setViewName("editpage");
        return  modelAndView;
    }
    // по сути заглушка. пока нет подключения к БД
    private static Train train;
    static {
        train=new Train();
        train.setId(1);
        train.setNumberTrain("Поезд №079 Мск-СПб");
        train.setCountPlace(31);
        train.setId(0057);
    }

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView allTrain() {
        ModelAndView modelAndView= new ModelAndView();
        // название нашего файла в структуре WEB, имя файла страницы
        modelAndView.setViewName("maintrain");
        modelAndView.addObject("train",train);
        return modelAndView;
    }



}

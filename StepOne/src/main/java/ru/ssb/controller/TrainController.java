package ru.ssb.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ru.ssb.service.TrainService;
import ru.ssb.model.Train;

import java.util.List;

@Controller
public class TrainController {
    /*  класс, который будет обрабатывать запросы, т.е. контроллер */

    private TrainService trainService;//= new TrainServiceImpl();
    @Autowired
    public void setTrainService(TrainService trainService) {
        this.trainService = trainService;
    }
    // главный метод для отображения страницы
        @RequestMapping(method = RequestMethod.GET)
        public ModelAndView allTrains() {
            List<Train> trains = trainService.allTrains();
            ModelAndView modelAndView = new ModelAndView();
            modelAndView.setViewName("maintrain");
            modelAndView.addObject("trainsList", trains);
            return modelAndView;
        }


        @RequestMapping(value = "/", method = RequestMethod.GET)
        public ModelAndView allTrain() {

            ModelAndView modelAndView = new ModelAndView();
            modelAndView.setViewName("maintrain");

            return modelAndView;
        }
        @RequestMapping(value = "/edit", method = RequestMethod.GET)
        public ModelAndView editPage() {
            ModelAndView modelAndView = new ModelAndView();
            modelAndView.setViewName("editpage");
            return modelAndView;
        }
        @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
        public ModelAndView editPage(@PathVariable("id") int id) {
            Train train = trainService.getById(id);
            ModelAndView modelAndView = new ModelAndView();
            modelAndView.setViewName("editPage");
            modelAndView.addObject("train", trainService.getById(id));
            return modelAndView;
        }
        @RequestMapping(value = "/edit", method = RequestMethod.POST)
        public ModelAndView editTrain(@ModelAttribute("train") Train train){
            ModelAndView modelAndView= new ModelAndView();
            modelAndView.setViewName("redirect:/");
            trainService.edit(train);
            return modelAndView;
        }
        @RequestMapping(value = "/add",method = RequestMethod.GET)
            public ModelAndView addPage() {
            ModelAndView modelAndView=new ModelAndView();
            modelAndView.setViewName("editPage");
            return modelAndView;
        }
        @RequestMapping(value = "/add", method = RequestMethod.POST)
            public ModelAndView addTrain(@ModelAttribute("train") Train train){
            ModelAndView modelAndView = new ModelAndView();
            modelAndView.setViewName("redirect:/");
            trainService.add(train);
            return modelAndView;
        }
        @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
            public ModelAndView deleteTrain(@PathVariable("id") int id){
            ModelAndView modelAndView= new ModelAndView();
            modelAndView.setViewName("redirect:/");
            Train train=trainService.getById(id);
            trainService.delete(train);
            return modelAndView;
        }

        @RequestMapping(value = "/delete", method = RequestMethod.GET)
            public ModelAndView deletePage(){
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.setViewName("/delete");
            return modelAndView;
        }
}

    // по сути заглушка. пока нет подключения к БД
   /* private static Train train;
    static {
        train=new Train();
        train.setId(1);
        train.setNumberTrain("Поезд №079 Мск-СПб");
        train.setCountPlace(31);
        train.setId(0057);
    }*/
/*
    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView allTrain() {
        ModelAndView modelAndView= new ModelAndView();
        // название нашего файла в структуре WEB, имя файла страницы
        modelAndView.setViewName("maintrain");
        modelAndView.addObject("train",train);
        return modelAndView;
    }
*/




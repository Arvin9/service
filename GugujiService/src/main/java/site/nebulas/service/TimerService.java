package site.nebulas.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import site.nebulas.util.DateUtil;
import site.nebulas.util.GugujiUtil;

@Component
public class TimerService {
  private Logger log = LoggerFactory.getLogger(TimerService.class);

  @Scheduled(cron = "0 0/1 * * * ?")
  public void minute() {
    log.info("定时任务: " + DateUtil.getTime());
  }

  @Scheduled(cron = "0 0 7,19 * * ?")
  public void everyday() {
    log.info("定时任务: " + DateUtil.getTime());
    log.info("咕咕鸡打印天气: " + GugujiUtil.getWeather());
    GugujiUtil.scripPrint(GugujiUtil.getWeather());
  }
}

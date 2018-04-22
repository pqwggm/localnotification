# localnotification

## 使用方法
### LocalNotification.init(Activity context): 初始化推送，传入所需要的应用Activity

### LocalNotification.pushMessage(String msg, long delay, int repeats)
- msg: 推送的内容
- delay: 延迟时间（单位：秒）
- 重复：1-每天 2-每小时 3-每分钟 4-每秒 0- 不重复

### LocalNotification.removeNotification(): 取消所有推送
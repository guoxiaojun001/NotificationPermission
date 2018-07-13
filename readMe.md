android 适配8.0 通知权限

private void createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {

            NotificationManager notificationManager = (NotificationManager)
                    getSystemService(Context.NOTIFICATION_SERVICE);

            //分组（可选）
            //groupId要唯一
            String groupId = "group_001";
            NotificationChannelGroup group = new NotificationChannelGroup(groupId, "广告");

            //创建group
            notificationManager.createNotificationChannelGroup(group);

            //channelId要唯一
            String channelId = "channel_001";

            NotificationChannel adChannel = new NotificationChannel(channelId,
                    "推广信息", NotificationManager.IMPORTANCE_DEFAULT);
            //补充channel的含义（可选）
            adChannel.setDescription("推广信息");
            //将渠道添加进组（先创建组才能添加）
            adChannel.setGroup(groupId);
            //创建channel
            notificationManager.createNotificationChannel(adChannel);

            //创建通知时，标记你的渠道id
            Notification notification = new Notification.Builder(MainActivity.this, channelId)
                    .setSmallIcon(R.mipmap.ic_launcher)
                    .setLargeIcon(BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher))
                    .setContentTitle("一条新通知")
                    .setContentText("这是一条测试消息")
                    .setAutoCancel(true)
                    .build();
            notificationManager.notify(1, notification);

        }
    }

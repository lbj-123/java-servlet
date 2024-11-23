<html>
<head>
    <%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <style>
        /* 设置全局样式 */
        body, html {
            margin: 0;
            padding: 0;
            font-family: Arial, sans-serif;
            display: flex;
            flex-direction: column;
            min-height: 100vh;
            background-color: #f4f4f9;
            color: #333;
        }

        /* 顶部标题区域 */
        .header {
            background-color: cornflowerblue;
            color: white;
            text-align: center;
            padding: 20px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
        }

        .header h1 {
            margin: 0;
            font-size: 28px;
        }

        /* 中间内容区域 */
        .inner {
            flex: 1;
            display: flex;
            flex-direction: column;
            align-items: center;
            justify-content: center;
            padding: 20px;
            text-align: center;
        }

        .inner img {
            max-width: 100px;
            margin-bottom: 20px;
        }

        .inner span {
            font-size: 20px;
            color: #555;
        }

        /* 底部链接区域 */
        .bottom {
            background-color: cornflowerblue;
            text-align: center;
            padding: 15px;
            color: white;
            box-shadow: 0 -4px 8px rgba(0, 0, 0, 0.1);
        }

        .bottom a {
            text-decoration: none;
            color: white;
            font-size: 18px;
            padding: 10px 20px;
            background-color: cornflowerblue;
            border-radius: 5px;
            transition: background-color 0.3s;
        }

        .bottom a:hover {
            background-color: cornflowerblue;
        }
    </style>
</head>
<body>
        <div class="header">
            <h1>税收完税证明文书式</h1>
        </div>

        <div class="inner">
            <img src="http://shfxv6xgh.hn-bkt.clouddn.com/testnav_pic_7.png" alt="Tax Document" />
            <span>税收完税证明</span>
        </div>

        <div class="bottom">
            <a href="http://shfxv6xgh.hn-bkt.clouddn.com/testwsbd.pdf" download="wspd.pdf">下载 PDF</a>
        </div>
</body>
</html>

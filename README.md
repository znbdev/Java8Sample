Java8 Sample
-----

# How to run

### Build code

##### Gradle build

```bash
cd [target repository dir]
./gradlew clean build --refresh-dependencies --stacktrace
```



# 以下是一个使用Ajax调用API并处理JSON响应的例子。这个例子使用jQuery来简化Ajax请求的编写和处理。如果你不想使用jQuery，也可以使用纯JavaScript的`XMLHttpRequest`或`fetch` API。

### HTML

首先，我们需要一个基本的HTML结构来触发Ajax请求并显示结果。

```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Ajax JSON Example</title>
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
</head>
<body>
    <h1>Ajax JSON Example</h1>
    <button id="fetchData">Fetch Data</button>
    <div id="result"></div>

    <script src="script.js"></script>
</body>
</html>
```

### JavaScript (jQuery)

接下来，我们编写JavaScript代码，使用jQuery进行Ajax调用。

```javascript
$(document).ready(function() {
    $('#fetchData').click(function() {
        $.ajax({
            url: 'https://api.example.com/data', // 替换为你的API URL
            method: 'GET',
            dataType: 'json',
            success: function(response) {
                $('#result').html(formatResponse(response));
            },
            error: function(xhr, status, error) {
                $('#result').html('Error: ' + error);
            }
        });
    });

    function formatResponse(response) {
        let html = '<ul>';
        response.forEach(item => {
            html += '<li>' + JSON.stringify(item) + '</li>';
        });
        html += '</ul>';
        return html;
    }
});
```

### JavaScript (Fetch API)

如果你更喜欢使用现代的`fetch` API，这里是等效的代码：

```javascript
document.addEventListener('DOMContentLoaded', function() {
    document.getElementById('fetchData').addEventListener('click', function() {
        fetch('https://api.example.com/data') // 替换为你的API URL
            .then(response => {
                if (!response.ok) {
                    throw new Error('Network response was not ok ' + response.statusText);
                }
                return response.json();
            })
            .then(data => {
                document.getElementById('result').innerHTML = formatResponse(data);
            })
            .catch(error => {
                document.getElementById('result').innerHTML = 'Error: ' + error;
            });
    });

    function formatResponse(response) {
        let html = '<ul>';
        response.forEach(item => {
            html += '<li>' + JSON.stringify(item) + '</li>';
        });
        html += '</ul>';
        return html;
    }
});
```

### 解释

1. **HTML**: 包含一个按钮用于触发Ajax请求，一个`div`用于显示结果，并引入了jQuery库和外部JavaScript文件。
2. **jQuery**:
    - 使用`$(document).ready`确保DOM加载完毕后执行代码。
    - 在按钮点击时触发Ajax请求，成功时将JSON数据格式化并显示在页面上，失败时显示错误信息。
3. **Fetch API**:
    - 使用`document.addEventListener`监听DOM内容加载完毕。
    - 在按钮点击时使用`fetch`进行Ajax请求，处理JSON响应并在页面上显示结果，错误时显示错误信息。

通过这些代码，你可以通过点击按钮来发送Ajax请求并显示API的JSON响应结果。记得将示例中的URL替换为你实际使用的API URL。
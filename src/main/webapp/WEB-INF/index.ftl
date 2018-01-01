<!DOCTYPE html>
<html>
<head>
    <title>local</title>
    <meta name="viewport" content="width=device-width,initial-scale=1.0">
    <link rel="stylesheet" type="text/css" href="/movie/statics/css/bootstrap.min.css">
</head>
<body>
    <div id="container" class="container" style="margin-top: 20px">
    </div>
    <div id="auth" class="container" style="margin-top: 50%">
        <input id="ip" type="hidden" value="${ipAddress!''}">
        <input id="path" type="hidden" value="${DEFAULT_PATH!''}">
        <div class="form-group">
            <input id="pwd" type="text" class="form-control" placeholder="Password">
        </div>
        <button id="auth_submit" type="submit" class="btn btn-primary btn-lg">Submit</button>
    </div>
    <script type="text/javascript" src="/movie/statics/js/lib/jquery-2.1.4.min.js"></script>
    <script type="text/javascript" src="/movie/statics/js/play.js"></script>
</body>
<!DOCTYPE html>
<html lang="en">
<style>
    fieldset {
        border: 3px double #cccccc;
        border-radius: 3px;
        margin: 20px 0;
        padding: 20px;
    }
</style>
<head>
    <meta charset="UTF-8">
    <title>Films</title>
</head>
<body>

<h10>Welcome to Cinema Database</h10>
<fieldset>
    <legend>Director's list</legend>
    <#if directors??>
    <#list directors as dir>
        <div>
            <a href="/directors/${dir.id}">
            ${dir.id}
            ${dir.first_name}
            ${dir.last_name}
            </a>
        </div>

    </#list>
    </#if>
    <br>
    <div>
        <form action="/" method="get">
            <button type="submit">Back to Main</button>
        </form>
    </div>
</fieldset>

</body>
</html>


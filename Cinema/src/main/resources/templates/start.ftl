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
    <#if director??>
    <#list director as dir>
        <div>
            ${dir.id}
            ${dir.first_name}
            ${dir.last_name}
        </div>
    </#list>
    </#if>
</fieldset>

<div>
    <a href="/filmsByIdOrDate">Find Films By ID or Date</a>
</div>
<div>
    <a href="/filmsById&Date">Find Films By ID and Date</a>
</div>
<div>
    <a href="/films/all">All Films and Directors</a>
</div>
</body>
</html>


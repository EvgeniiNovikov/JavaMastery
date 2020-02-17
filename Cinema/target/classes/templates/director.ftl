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
<fieldset>
    <legend>Search:</legend>
    <div>
        <#if director??>
            ${director.toString()}
            <div>
                <#if director.films??>
                    <#list director.films as film>
                        <div>
                            <a href="/movies/${film.id}">
                            ${film.name}</a>
                            ${film.genre}
                            ${film.release_date}
                        </div>
                    </#list>
                </#if>
            </div>
        </#if>
    </div>
    <br>
    <div>
        <form action="/" method="get">
            <button type="submit">Back to Main</button>
        </form>
    </div>
</fieldset>
</body>
</html>
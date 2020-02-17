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
        Enter Date from:
        <form action="/movies/date" method="get">
            <div>
                <input type="date" pattern="yyyyMMdd" name="from">
            </div>
            <br>
            Enter Date to:
            <div>
                <input type="date" pattern="yyyyMMdd" name="to">
            </div>
            <div>
                <br>
                <button type="submit">Search By Date</button>
            </div>
        </form>
        <br>
    </div>
    <div>
        <#if films??>
            <#list films as film>
                <div>
                    <a href="/movies/${film.id}">
                    ${film.name}
                    </a>
                    ${film.genre}
                    ${film.release_date}
                    <a href="/directors/${film.director.id}">
                    ${film.director.first_name}
                    ${film.director.last_name}
                    </a>
                </div>
            </#list>
        </#if>
        <#--        <#if director??>-->
        <#--        <#list director as dir>-->
        <#--        <a href="localhost:8080/movies/director/${dir.id}/date?from=<ДАТА С>&to=<ДАТА ДО>">-->
        <#--            <div>-->
        <#--                <#list dir.films! as film>-->
        <#--                    <div>-->
        <#--                        ${film.toString()}-->
        <#--                    </div>-->
        <#--                </#list>-->
        <#--            </div>-->
        <#--            </#list>-->
        <#--            </#if>-->
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
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
        Enter Director's ID:
        <form action="/filmsById" method="post">
            <input type="text" name="id" placeholder="${id!}">
            <button type="submit">Search By Id</button>
        </form>
    </div>
    <div>
        Enter Date:
        <form action="/filmsByDate" method="post">
            <input type="text" name="date" placeholder="${info!}">
            <button type="submit">Search By Date</button>
        </form>
        <br>
    </div>
    <div>
        <#if films??>
            <#list films as film>
                <div>
                    ${film.toString()}
                    ${film.director.first_name}
                    ${film.director.last_name}
                </div>
            </#list>
        </#if>
        <#if director??>
            <#list director as dir>
                ${dir.toString()}
                <div>
                    <#list dir.films! as film>
                        <div>
                            ${film.toString()}
                        </div>
                    </#list>
                </div>
            </#list>
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
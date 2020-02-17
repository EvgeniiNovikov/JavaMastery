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

<fieldset>
    <legend>Search:</legend>
    <div>
        <form action="/movies/director/{id}/date" method="get">
            Enter Director's ID:
            <div>
                <input type="number" name="id">
            </div>
            Enter Date from:
            <div>
                <div>
                    <input type="date" pattern="yyyyMMdd" name="from">
                </div>
            </div>
            Enter Date to:
            <div>
                <div>
                    <input type="date" pattern="yyyyMMdd" name="to">
                </div>
                <div>
                    <br>
                    <button type="submit">Search</button>
                </div>
            </div>
        </form>
    </div>
    <br>
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
    <br>
    <div>
    <form action="/" method="get">
        <button type="submit">Back to Main</button>
    </form>
    </div>
</fieldset>
</html>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <title>Bootstrap Card Example</title>

</head>
<body>

<div class="container mt-5">

    <div class="card" style="width: 18rem;">
        <div class="card-header">
            JAVABANK - Customer #${customer.id}
        </div>
        <ul class="list-group list-group-flush">
            <li class="list-group-item">${customer.name}</li>
            <li class="list-group-item">${customer.email}</li>
            <li class="list-group-item">${customer.phone}</li>
        </ul>
    </div>
</div>

</body>
</html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="pt">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <title>Perfil do Cliente - JavaBank</title>

    <style>
        body {
            background-color: #f4f6f9;
            font-family: 'Arial', sans-serif;
        }

        .card {
            border-radius: 15px;
            box-shadow: 0 4px 12px rgba(0, 0, 0, 0.1);
        }

        .card-header {
            background-color: #007bff;
            color: white;
            font-weight: bold;
            border-radius: 15px 15px 0 0;
            font-size: 1.25rem;
            display: flex;              /* Ativando Flexbox */
            align-items: center;       /* Alinhando verticalmente */
            justify-content: center;   /* Centralizando horizontalmente */
            height: 100px;             /* Ajustando a altura do cabeçalho */
        }

        .list-group-item {
            border: none;
            padding: 15px;
            font-size: 1.1rem;
        }

        .list-group-item:first-child {
            border-top-left-radius: 15px;
            border-top-right-radius: 15px;
        }

        .list-group-item:last-child {
            border-bottom-left-radius: 15px;
            border-bottom-right-radius: 15px;
        }

        .icon {
            margin-right: 10px;
        }

        .btn-custom {
            background-color: #28a745;
            color: white;
            border-radius: 50px;
            padding: 8px 20px;
            font-size: 1rem;
            width: 200px;
            margin-top: 20px;
        }

        .btn-custom:hover {
            background-color: #218838;
            text-decoration: none;
        }

        .container {
            margin-top: 50px;
            display: flex;
            justify-content: center;
        }
    </style>

</head>
<body>

<div class="container">
    <div class="card" style="width: 22rem;">
        <div class="card-header text-center">
            <i class="bi bi-person-circle icon" style="font-size: 2rem;"></i> <br> JAVABANK - Customer #1
        </div>
        <div class="card-body">
            <ul class="list-group list-group-flush">
                <li class="list-group-item">
                    <i class="bi bi-person-fill icon"></i>
                    <strong>Name:</strong> ${name}
                </li>
                <li class="list-group-item">
                    <i class="bi bi-envelope-fill icon"></i>
                    <strong>Email:</strong> ${email}@gmail.com
                </li>
                <li class="list-group-item">
                    <i class="bi bi-telephone-fill icon"></i>
                    <strong>Phone:</strong> ${phone}
                </li>
            </ul>
        </div>
    </div>
</div>

<!-- Bootstrap Icons (CDN) for the icons used above -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap-icons/font/bootstrap-icons.js"></script>
</body>
</html>

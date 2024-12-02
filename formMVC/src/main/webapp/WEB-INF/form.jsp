<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="pt">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Formulário de Cliente</title>

    <!-- Link para o Bootstrap (para estilizar melhor) -->
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">

    <style>
        body {
            background-color: #f7f9fc;
            font-family: 'Arial', sans-serif;
            margin: 0;
            padding: 0;
        }

        .container {
            max-width: 600px;
            margin-top: 50px;
            padding: 30px;
            background-color: #ffffff;
            border-radius: 8px;
            box-shadow: 0 4px 12px rgba(0, 0, 0, 0.1);
        }

        .input-group-text {
            background-color: #007bff;
            color: white;
        }

        .form-control {
            border-radius: 8px;
            padding: 12px;
        }

        .form-label {
            font-weight: 600;
            color: #333;
        }

        .form-text {
            color: #6c757d;
        }

        .btn-submit {
            background-color: #28a745;
            color: white;
            border-radius: 8px;
            border: none;
            padding: 12px 20px;
            font-size: 16px;
            margin-top: 20px;
            width: 100%;
        }

        .btn-submit:hover {
            background-color: #218838;
        }

        .mb-3 {
            margin-bottom: 1.5rem;
        }

        .input-group {
            margin-bottom: 1.5rem;
        }

        .input-group .form-control {
            border-radius: 8px;
        }
    </style>
</head>
<body>

    <div class="container">
        <h2 class="text-center mb-4">Formulário de Cliente</h2>

        <form method="post">

            <!-- Username Input -->
            <div class="input-group mb-3">
                <span class="input-group-text" id="basic-addon1">@</span>
                <input type="text" class="form-control" placeholder="Nome" name="name" aria-describedby="basic-addon1" required>
            </div>

            <!-- Recipient's Username Email Input -->
            <div class="input-group mb-3">
                <input type="text" class="form-control" placeholder="Email" name="email" aria-describedby="basic-addon2" required>
                <span class="input-group-text" id="basic-addon2">@gmail.com</span>
            </div>

           <!-- Username Input -->
                       <div class="input-group mb-3">
                           <span class="input-group-text" id="basic-addon1"><svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-telephone" viewBox="0 0 16 16">
                                                                              <path d="M3.654 1.328a.678.678 0 0 0-1.015-.063L1.605 2.3c-.483.484-.661 1.169-.45 1.77a17.6 17.6 0 0 0 4.168 6.608 17.6 17.6 0 0 0 6.608 4.168c.601.211 1.286.033 1.77-.45l1.034-1.034a.678.678 0 0 0-.063-1.015l-2.307-1.794a.68.68 0 0 0-.58-.122l-2.19.547a1.75 1.75 0 0 1-1.657-.459L5.482 8.062a1.75 1.75 0 0 1-.46-1.657l.548-2.19a.68.68 0 0 0-.122-.58zM1.884.511a1.745 1.745 0 0 1 2.612.163L6.29 2.98c.329.423.445.974.315 1.494l-.547 2.19a.68.68 0 0 0 .178.643l2.457 2.457a.68.68 0 0 0 .644.178l2.189-.547a1.75 1.75 0 0 1 1.494.315l2.306 1.794c.829.645.905 1.87.163 2.611l-1.034 1.034c-.74.74-1.846 1.065-2.877.702a18.6 18.6 0 0 1-7.01-4.42 18.6 18.6 0 0 1-4.42-7.009c-.362-1.03-.037-2.137.703-2.877z"/>
                                                                            </svg></span>

                           <input type="text" class="form-control" placeholder="Número" name="phone" aria-describedby="basic-addon1" required>
                       </div>

            <!-- Submit Button -->
            <div class="text-center">
                <button type="submit" class="btn-submit">Enviar</button>
            </div>
        </form>
    </div>

    <!-- Link para o Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.2/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>

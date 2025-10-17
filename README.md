# 🌕 Peso En La Luna 🚀

## 🪐 Descripción

**Peso En La Luna** es una aplicación Android sencilla y educativa que calcula cuánto pesarías si estuvieras en la **superficie de la Luna** 🌝.  
Está desarrollada en **Kotlin** utilizando el poder de **Data Binding**, una característica que permite conectar directamente la interfaz de usuario con la lógica de datos, reduciendo código repetitivo y mejorando la mantenibilidad del proyecto.

---

## ✨ Características

- 🧮 Calcula tu peso lunar en función del peso ingresado en la Tierra.  
- 🔗 Implementa **Data Binding** para enlazar los datos entre la vista y el modelo.  
- 💅 Interfaz limpia y moderna.  
- 🌗 Compatible con temas claros y oscuros.  

---

## 🧩 Tecnologías utilizadas

| Tecnología | Uso |
|-------------|-----|
| **Kotlin** | Lenguaje principal de desarrollo |
| **Android Studio** | Entorno de desarrollo |
| **Data Binding** | Comunicación directa entre UI y datos |
| **XML Layouts** | Diseño de interfaz de usuario |
| **Gradle** | Sistema de compilación y dependencias |

---

## ⚙️ Instalación y ejecución

1. Clona este repositorio:
   ```bash
   git clone https://github.com/tuusuario/PesoEnLaLuna.git
Abre el proyecto con Android Studio.

Espera a que Gradle sincronice las dependencias.

Ejecuta la app en un emulador o en tu dispositivo físico.

💡 Cómo funciona
El usuario ingresa su peso en la Tierra 🌍 y la app aplica el factor de gravedad lunar (≈ 0.165) para calcular el peso equivalente en la Luna.

kotlin

val pesoTierra = binding.editPeso.text.toString().toDouble()
val pesoLuna = pesoTierra * 0.165
binding.txtResultado.text = "Tu peso en la Luna es: %.2f kg".format(pesoLuna)
Gracias al uso de Data Binding, los elementos del layout (activity_main.xml) están conectados directamente con las propiedades del código, eliminando la necesidad de findViewById().

🧠 Configuración de Data Binding
Para activar Data Binding en tu proyecto, agrega lo siguiente en el archivo build.gradle.kts (módulo app):

kotlin

android {
    ...
    buildFeatures {
        dataBinding = true
    }
}
Y en tu layout principal (activity_main.xml), asegúrate de envolver el contenido dentro de la etiqueta <layout>:

xml

<layout xmlns:android="http://schemas.android.com/apk/res/android">
    <data>
        <!-- Aquí puedes declarar variables si las usas -->
    </data>

    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:gravity="center"
        android:orientation="vertical"
        android:padding="24dp">

        <EditText
            android:id="@+id/editPeso"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:hint="Ingresa tu peso en la Tierra" />

        <Button
            android:id="@+id/btnCalcular"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:text="Calcular" />

        <TextView
            android:id="@+id/txtResultado"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:textSize="18sp"
            android:paddingTop="16dp" />
    </LinearLayout>
</layout>
En tu MainActivity.kt, la inicialización se realiza así:

kotlin

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnCalcular.setOnClickListener {
            val pesoTierra = binding.editPeso.text.toString().toDoubleOrNull()
            if (pesoTierra != null) {
                val pesoLuna = pesoTierra * 0.165
                binding.txtResultado.text = "Tu peso en la Luna es: %.2f kg".format(pesoLuna)
            } else {
                binding.txtResultado.text = "Por favor, ingresa un número válido."
            }
        }
    }
}


📚 Aprendizaje clave
Este proyecto demuestra cómo:

Activar y usar Data Binding en un proyecto Android moderno.

Enlazar variables de UI directamente con la lógica de negocio.

Reducir el uso de findViewById() y mejorar la legibilidad del código.

Crear una app funcional y didáctica con un diseño limpio.

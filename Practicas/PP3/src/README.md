Abdiel Calderón - FI25052739
IDE: Visual Studio Code

Fuentes consultadas: ChatGPT.com, grabación de la clase del 27/10/2025

Prompts y respuestas:

Input:
“Mi código de la lista circular doblemente enlazada compila bien, pero cuando lo ejecuto no aparecen los valores de los nodos. No sé exactamente qué método puede estar mal. ¿Qué me recomiendas revisar? Aquí está mi código: (código)”

Output:
Por lo que describís, es probable que el problema esté en el método removeLast(). Aunque el código compile, si en ese método las referencias de los punteros no se actualizan correctamente, la lista puede romper su estructura interna y dejar de imprimir los valores. Te recomiendo verificar cómo se manejan los casos donde la lista tiene un solo elemento, ya que ahí head y tail deberían pasar a ser null. También asegurate de que cuando hay varios nodos, el puntero tail.next siga apuntando al head y que head.prev apunte al nuevo tail. Si alguno de esos enlaces se pierde, la lista se “desconecta” y los métodos de impresión ya no muestran los datos aunque la compilación sea exitosa.


Preguntas:  

Si tuviera que implementar una estructura tipo Cola (Queue), qué tipo de lista (simple, circular, doblemente enlazada o circular doblemente enlazada) utilizaría y por qué? ¿Y para una estructura tipo Pila (Stack)?

    - Usaría una lista circular doblemente enlazada para la Cola porque permite agregar por un lado y quitar por el otro de forma rápida.
    - Para la Pila usaría una lista simplemente enlazada porque solo se trabaja con el último elemento y es más fácil de manejar.

¿Cuál cree que podría ser una ventaja y una desventaja de utilizar una estructura de tipo lista creada por usted mismo, en vez de las opciones provistas directamente por los módulos estándar de Java (como por ejemplo List)?

    - Ventaja: Es mucho más fácil de comprender cómo funciona internamente la estructura de las listas y, además, se pueden personalizar más para casos específicos.
    - Desventaja: Es más complejo de crear, ya que se deben programar todos los métodos desde cero, mientras que las listas que provee Java ya tienen funciones implementadas y son mucho más sencillas de manipular.
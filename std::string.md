## String

```cpp
#include <string>

// count : substring #
int count = std::count(str.begin(), str.end(), 'substring'); // invalid
```
### find 
```
std::string str = "hello world";
auto it= std::find(str.begin(), str.end(), 'o'); //
```
-> will this be availble for substring ?
```
    std::string str = "hello world";
    std::string substring = "world";
    
    // Use std::string::find to find the substring
    size_t pos = str.find(substring);
```

## stringstream

```
#include <sstream>
stringstream str ();
```

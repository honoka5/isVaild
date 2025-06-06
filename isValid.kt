fun isValid(s:String): Boolean {
    var chars=s.toList()//１文字ずつに直している
    val pea =mapOf("(" to ")","{" to "}","[" to "]")
   	var stack=mutableListOf<Char>()

    for(char in chars){
        if(pea.containsKey(char.toString())){
        	stack.add(char)
        }else{ 
        	if(stack.isEmpty())
        		return false
        	val stackFirst=stack.removeAt(stack.size-1)//{,(,[を追加していく、最後に追加した文字のインデックスを渡して消している。
            val stackLast = pea[stackFirst.toString()]//取り出した｛に合う｝などをpeaから取得
                if(stackLast !=char.toString())//合うものがない（｝、],)）
                    return false
        }
    }
    return stack.isEmpty()
}


fun main(){
   //var s="()"
   //var s="[]"
   //var s="{}"
   var  s="{][]}"
   println("\"$s\" ${isValid(s)}")
}

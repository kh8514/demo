import './App.css'
import {useEffect, useState} from "react";
import {fetchMemos, createMemo} from "./api.js";

function App() {
  const [memos, setMemos] = useState([]);
  const [content, setContent] = useState('');
  const [error, setError] = useState('');

  const load = async () => {
    try {
      setMemos(await fetchMemos());
    } catch (e) {
      setError(e.message);
    }
  };

  useEffect(() => {
    load();
  }, []);

  const handleSubmit = async (e) => {
    e.preventDefault();
    if (!content.trim()) return;
    try{
      await createMemo(content);
      setContent('');
      setError('');
      await load();
    } catch (e) {
      setError(e.message);
    }
  }

  return (
      <div className="container">
        <h1>메모</h1>

        <form onSubmit={handleSubmit}>
          <input
              value={content}
              onChange={(e) => setContent(e.target.value)}
              placeholder="메모를 입력하세요"
          />
          <button type="submit">저장</button>
        </form>

        {error && <p className="error">{error}</p>}

        <ul>
          {memos.map((memo) => (
              <li key={memo.id}>{memo.content}</li>
          ))}
        </ul>
      </div>
  )

}

export default App

const BASE_URL = '/api/memos';

export async function fetchMemos() {
    const res = await fetch(BASE_URL);
    if (!res.ok) throw new Error(`조회 실패: ${res.status}`);
    return res.json();
}

export async function createMemo(content) {
    const res = await fetch(BASE_URL, {
        method: 'POST',
        headers: { 'Content-Type': 'application/json'},
        body: JSON.stringify({content}),
    });
    if (!res.ok) throw new Error(`저장 실패: ${res.status}`);
    return res.json();
}